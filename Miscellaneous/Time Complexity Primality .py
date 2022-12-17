from math import *
p = int(input().strip())
for a0 in range(p):
    n = int(input().strip())
    f=5
    if(n!=1):
        for i in range(2,int(sqrt(n))):
            if(n%i==0):
                f=0
    if(f==0 or n==1):
        print("Not prime")
    else:
        print("Prime")

