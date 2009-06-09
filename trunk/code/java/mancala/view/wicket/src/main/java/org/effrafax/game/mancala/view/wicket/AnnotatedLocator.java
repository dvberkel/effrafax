/**
 * 
 */
package org.effrafax.game.mancala.view.wicket;

import java.util.HashMap;
import java.util.Map;

import org.apache.wicket.util.resource.IResourceStream;
import org.apache.wicket.util.resource.locator.ResourceStreamLocator;
import org.effrafax.game.mancala.view.wicket.annotation.DefaultMapping;
import org.effrafax.game.mancala.view.wicket.annotation.PathMapping;
import org.effrafax.game.mancala.view.wicket.annotation.PathMappings;

/**
 * @author dwanrooy
 *
 */
@PathMappings({
	@PathMapping(
			path="org/effrafax/game/mancala/view/wicket",
			mapsTo="wicket"
	)
})
public class AnnotatedLocator extends ResourceStreamLocator {
	
	private static final String DEFAULT_KEY = "[DEFAULT_KEY]";
	
	private Map<String, String> pathMapping = new HashMap<String, String>();
	
	public AnnotatedLocator() {
		
		processPathMappings();
	}
	
	/* (non-Javadoc)
	 * @see org.apache.wicket.util.resource.locator.ResourceStreamLocator#locate(java.lang.Class, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public IResourceStream locate(Class clazz, String path) {
				
		return super.locate(clazz, pathMapsTo(path));
	}
	
	private void processPathMappings() {
		
		Map<String, String> map = getPathMapping();
		Class<?> clazz = this.getClass();
		
		PathMappings pathMappings = clazz.getAnnotation(PathMappings.class);
		if (pathMappings != null) {
			
			for (PathMapping pathMapping : pathMappings.value()) {
				
				String path = pathMapping.path();
				String mapsTo = pathMapping.mapsTo();
				
				map.put(path, mapsTo);
			}
		}
		
		DefaultMapping defaultMapping = 
			clazz.getAnnotation(DefaultMapping.class);
		if (defaultMapping != null) {
			
			String mapsTo = defaultMapping.value();
			
			map.put(DEFAULT_KEY, mapsTo);
		}
	}

	private String pathMapsTo(String path) {
		
		Map<PathPart, String> extract = extractBase(path);
		Map<String, String> map = getPathMapping();
		
		String mapsTo;
		if (map.containsKey(extract.get(PathPart.BASE))) {
			
			mapsTo = compose(
					map.get(extract.get(PathPart.BASE)), 
					extract.get(PathPart.FILE)
			);
		} else if (map.containsKey(DEFAULT_KEY)) {
			
			mapsTo = compose(
					map.get(DEFAULT_KEY), 
					extract.get(PathPart.FILE)
			);			
		} else {
			
			mapsTo = path;
		}
		
		return mapsTo;
	}
	
	private String compose(String base, String file) {
		
		return base + "/" + file;
	}
	
	private Map<PathPart, String> extractBase(String path) {
		
		int lastSlashindex = path.lastIndexOf("/");
		
		Map<PathPart, String> extract = new HashMap<PathPart, String>();
		if (lastSlashindex == -1) {
			
			/* path does not contain a '/'. */
			extract.put(PathPart.BASE, "");
			extract.put(PathPart.FILE, path);
		} else {
			
			/* path does contain a '/'. */
			extract.put(PathPart.BASE, path.substring(0, lastSlashindex));
			extract.put(PathPart.FILE, path.substring(lastSlashindex + 1));
		}
		
		return extract;
	}
	
	/**
	 * @return the pathMapping
	 */
	private Map<String, String> getPathMapping() {
		
		return pathMapping;
	}
	
	private enum PathPart {
	
		BASE, FILE;
	}

}
