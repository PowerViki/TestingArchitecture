from util import util
import os

def delete_file(file_name):
    if os.path.exists(file_name):
        os.remove(file_name)

class csv2Html:
    
    def __init__(self, csv):
        self.csv = csv + ".csv"
        self.html = ""
        self.dHtml = csv + ".html"
        self.util=util()
                
    def print_start(self):
        self.html=self.html + "<table border='1' border='1' cellpadding='1' cellspacing='0' align='center'>"
            
    def print_end(self):
        self.html=self.html + "</table>"        
        
    def print_line(self, line, color,maxwidth):
        self.html=self.html + "<tr bgcolor='{}'>".format(color)
        fields = self.extract_fields(line)
        for field in fields:
            if not field:
                self.html=self.html + "<td></td>"
            else:
                number = field.replace(",", " ")
                try:
                    x = float(number)
                    self.html=self.html + "<td align='center'>{0:d}</td>".format(round(x))
                except ValueError:
#                     field = field.title()
                    field = field.replace("And", "and")
                    if len(field) <= maxwidth:
                        field = self.escape_html(field)
                    else:
                        field = "{0}...".format(self.escape_html(field[:maxwidth]))
                    self.html=self.html + "<td align='center'>{0}</td>".format(field)
        self.html=self.html + "</tr>"
        
        
    def extract_fields(self, line):
        fields = []
        field = ""
        quote = None
        for c in line:
            if c in "\"":
                if quote is None:
                    quote = c
                elif quote == c:
                    quote = None
                else:
                    field += c
                    continue
            if quote is None and c == ",":
                fields.append(field)
                field = ""
            else:
                field  += c
        if field:
            fields.append(field)
        return fields
            
    def escape_html(self, text):
        text = text.replace("&", "&amp;")
        text = text.replace("<", "&lt;")
        text = text.replace(">", "&gt;")
        return text
    
    def generate(self):
        maxwidth = 100
        self.print_start()
        count = 0
        f = open(self.csv, "r")
        while(True):
            line = f.readline().replace("\n", "")
            if (line != ""):
                if count == 0:
                    color = "lightgreen"
                elif count % 2:
                    color = "white"
                else:
                    color = "lightyellow"
                self.print_line(line, color, maxwidth)
                count += 1
            else:   
                break             
        f.close()
        self.print_end()
        self.util.logFinalFile(self.dHtml, self.html)
        
if __name__ == '__main__':
    delete_file("../report/TestResult.html")
    obj = csv2Html("../report/TestResult")
    obj.generate()
