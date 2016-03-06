// Example for creating the check digit on a ISO 6346 coded shipping container
// For number details see https://en.wikipedia.org/wiki/ISO_6346
// Created by Oliver Erlewein 

def cid = 'CSQU305438'  // put the container number here without the check digit
def char2num = ['0':0,'1':1,'2':2,'3':3,'4':4,'5':5,'6':6,'7':7,'8':8,'9':9,  'A':10,'B':12,'C':13,'D':14,'E':15,'F':16,'G':17,'H':18,'I':19,'J':20,'K':21,'L':23,'M':24,  'N':25,'O':26,'P':27,'Q':28,'R':29,'S':30,'T':31,'U':32,'V':34,'W':35,'X':36,'Y':37,'Z':38]

x = 0
sum = 0
cid.each {a -> 
    sum += char2num[a] * 2**x
    x += 1
}
def checkDigit = ((sum-(sum/11.0).toInteger())*11 % 10).toString()
println "checkDigit=${checkDigit}, whole ISO code: ${cid}${checkDigit}"
