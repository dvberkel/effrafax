#! /usr/bin/env python

import TapeCell

class TM:
	
	tapeHead = None
		
	def __init__(self):
		self.tapeHead = TapeCell.TapeCell();
	
	def moveHeadLeft(self):
		self.tapeHead = self.tapeHead.getLeftCell()
	
	def moveHeadRight(self):
		self.tapeHead = self.tapeHead.getRightCell()	
	
	def write(self, content):
		self.tapeHead.setContent(content)
	
	def read(self):
		return self.tapeHead.getContent();
	
if __name__ == '__main__':
	
	tm = TM()
	
	tm.write("o")
	tm.moveHeadLeft();
	
	tm.write("l")
	tm.moveHeadLeft();
	
	tm.write("l")
	tm.moveHeadLeft();
	
	tm.write("e")
	tm.moveHeadLeft();
	
	tm.write("h")

	while tm.read() != None:
		
		print '%s' % tm.read()
		tm.moveHeadRight()
