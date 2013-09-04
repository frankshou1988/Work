#/usr/bin/python
import os

#count the line of a single file
def CountLine(path):
        tempfile = open(path)
        res = 0
        for lines in tempfile:
                res += 1
        print "%s %d" %(path, res) #output the file path and lines
        return res

#count the total line of a folder, sub folder included
def TotalLine(path):
        total = 0
        for root, dirs, files in os.walk(path):
                for item in files:
                        ext = item.split('.')
                        ext = ext[-1]  #get the postfix of the file
                        if(ext in ["cpp", "c", "h", "java", "py", "php"]):
                                subpath = root + "/" + item
                                total += CountLine(subpath)
        return total

print "Input Path"
path = raw_input()
print TotalLine(path)
raw_input("press any key to continue...");
