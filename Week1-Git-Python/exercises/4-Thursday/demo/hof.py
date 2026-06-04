# High Order Function can be assigned to a variable 
# that a function can be passed as an argument to another function
# can be written from the function

def greet(name):
  return f"Hello {name}!"

# Assign it to a variable
say_hello = greet
print(say_hello("Audy"))

# Pass function as argument
def apply(func,value):
  return func(value)

print(apply(greet,"Emily"))

