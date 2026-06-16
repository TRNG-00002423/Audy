# List : ordered and mutable collections of items

# Empty List
tests = []

# List with some values
tests = ["login","search","checkout"]
mixed_list = [1, "login", True, "search", "checkout"]

print(tests[0])
print(tests[-1])

# Modify a List
tests[1] = "advance search"
tests.append("logout")
tests.insert(0,"open page")
print(tests)

tests.remove("login")
removed = tests.pop()

del tests[0]

len(tests) # returns the length of the list

"login" in tests # T or F

tests.index("checkout")

tests.count("login") #how many times the value appears in the list

tests.sort() #ascending

tests.sort(reverse=True) # reverse sort in descending order

tests.reverse() 

nums = [1,2,3,4,5,6]
print(nums[1:4]) # slicing

nums[:4] # starts from the index 0 to 4 (not including)
nums[3:] # starts from the index 3