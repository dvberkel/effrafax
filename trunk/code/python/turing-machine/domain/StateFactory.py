#! /usr/bin/env python

class StateFactory:
	
	states = []
		
	class State:
		
		id
		
		def __init__(self, id):
			self.id = id
		
		def __str__(self):
			return 'q%d' % self.id
			
	def __init__(self):
		pass
	
	def getNumberOfStates(self):
		return len(self.states)
	
	def getNewState(self):
		
		state = StateFactory.State(self.getNumberOfStates())
		self.states += [state]
		
		return state;
	
	def getStates(self):
		return self.states
	
if __name__ == '__main__':
	
	factory = StateFactory()
	
	state0 = factory.getNewState();
	state1 = factory.getNewState();
	
	print factory.getNumberOfStates();
	print state0

