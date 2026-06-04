# Map, Reduce, Filter, Zip

#Map: map() applies a function to every element of an iterable

nums = [1,2,3,4,5]
double = list(map(lambda x: x*2, nums))
print(double)

names = ["Oscar","Audy","Curtis","Anuha"]
# Capitalize each name
cap = list(map(lambda x: x.upper(),names))
print(cap)