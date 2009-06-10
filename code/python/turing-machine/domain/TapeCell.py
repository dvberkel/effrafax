#! /usr/bin/env python

class TapeCell:
	
	content = None
	leftCell = None
	rightCell = None
	
	def __init__(self):
		pass;
	
	def getLeftCell(self):
		if (self.leftCell is None):
			self.leftCell = TapeCell()
			self.leftCell.setRightCell(self)
		
		return self.leftCell
	
	def setLeftCell(self, cell):
		self.leftCell = cell;
	
	def getRightCell(self):
		if (self.rightCell is None):
			self.rightCell = TapeCell()
			self.rightCell.setLeftCell(self);
		
		return self.rightCell;
	
	def setRightCell(self, cell):
		self.rightCell = cell
	
	def getContent(self):
		return self.content
	
	def setContent(self, content):
		self.content = content
	

if __name__ == '__main__':
	
	cell = TapeCell()
	
	left = cell.getLeftCell()
	right = cell.getRightCell()
	
	left.setContent("A")
	cell.setContent("B")
	right.setContent("C")
