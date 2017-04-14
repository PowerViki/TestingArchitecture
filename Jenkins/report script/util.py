import math

class util:

    def logFinalFile(self, logPath, content):
        f = open(logPath, "a")
        f.write(content)
        print(content)
        f.close()
    
    def copyFinalFile(self, logPath):
        tmp = ""
        count = 0
        f = open(logPath, "r")
        while(True):
            line = f.readline()
            if(line != ""):
                if (count == 0 or count%2 == 1):
                    tmp = tmp + line
            else:   
                break  
            count += 1
        f.close()
        fn = open(logPath, "w") 
        print(tmp)  
        fn.write(tmp)
        fn.close()
        
    def getMedian(self, lists):
            tmp = 0
            if(len(lists) > 1):
                if(len(lists) % 2 == 0):
                    index = len(lists) / 2 - 1
                    tmp = (lists[index] + lists[index + 1]) / 2
                else:  
                    index = (len(lists) - 1) / 2
                    tmp = lists[index]
            else:
                tmp = lists[0]
            return tmp
                
    def getStd(self,lists):
        tmp = 0
        if(len(lists) > 1):
            
            for i in lists:
                tmp += float(i)
            avg = float(tmp) / len(lists)
            tmp = 0
            i = 0
            for i in lists:
                i = float(i)
                tmp += (i - avg) * (i - avg)
            tmp = float(tmp) / (len(lists) - 1)
            tmp = math.sqrt(tmp)
        return tmp 

        
        
        
        