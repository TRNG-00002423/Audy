# Map, Reduce, Filter, Zip

#Map: map() applies a function to every element of an iterable

nums = [1,2,3,4,5]
double = list(map(lambda x: x*2, nums))
print(double)

names = ["Oscar","Audy","Curtis","Anuha"]
# Capitalize each name
cap = list(map(lambda x: x.upper(),names))
print(cap)

# filter() - filters based on a predicate function or condition
nums = [1,2,3,4,5,6,7,8,9,10]

# evens = ????
even_nums = list(filter(lambda x: x%2== 0, nums))
print(even_nums)

# reduce() - often used as aggegrator
from functools import reduce
nums = [1,2,3,4,5] # sum

result = reduce(lambda a,x: a+x, nums)

# zip () takes 2 or more iterables and combines the element by element in tples
name = ["Ken","Natalie","Thomas"]
grade = [85,92,84]
zip_name_grade = zip(names, grade)

list_name_grade = list(zip_name_grade)
print(list_name_grade)