# lambda short form of writing function
# anonymous function (no name - def statement return statement)

# regular function
def add(a,b):
  return a + b

# lambda high order function (assigning to a variable)
# will the calculation be completed in one single-line? YES
add_lambda = lambda a,b: a+b

print(add(2,3))
print(add_lambda(3,3))

# Map, Reduce, Filter, Zip

