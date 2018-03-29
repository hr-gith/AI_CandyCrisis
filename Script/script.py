import random
s1="errrrrbwbbwybry"
s2="rrrrrrbbbbwwyye"
s3="rrrrbbbbwwyygge"
s4="rrrrbbwwyyggppe"
for i in range(30):
	output=''.join(random.sample(s2,len(s2)))
	#print output
	print(" ".join(output))
