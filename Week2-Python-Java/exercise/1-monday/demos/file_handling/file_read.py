file = open("data.txt","r")

# Read Entire File
# content = file.read()
# print(content)
# print("*"*20)

# Read One Line
#good for for-loop
# line = file.readline()
# print(line)

# REad all lines (shows in list)
lines = file.readlines()
print(lines)

file.close()