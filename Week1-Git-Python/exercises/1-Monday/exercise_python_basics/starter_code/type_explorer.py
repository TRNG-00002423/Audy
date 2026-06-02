age = 28
price = 19.99
name = "Alice"
is_active = True
result = None

print("\nVariable Exploration:")
print(f"age = {age} (type: {type(age)})")
print(f"price = {price} (type: {type(price)})")
print(f"name = {name} (type: {type(name)})")
print(f"is_active = {is_active} (type: {type(is_active)})")
print(f"result = {result} (type: {type(result)})")

# Demonstrate Operators
a = 17
b = 5

print("\nOperators Demo:")
print(f" {a} // {b}  = {a // b} (Floor Division)")
print(f" {a} / {b}  = {a / b} (True Division)")
print (f" 'QA ' * 3 = {'QA ' * 3}")
print(f"True + True = {True + True}")

#Precision Gotcha
print("\nPrecision Gotcha:")
print(f"0.1 + 0.2 = {0.1 + 0.2} (not exactly 0.3)")