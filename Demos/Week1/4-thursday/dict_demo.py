# Dictionaru : Key - value pair

student = {
  "name": "Utsav",
  "age": 25,
  "grade": "A"
}

print(student["name"])
print(student.get("age"))

student["grade"] = "A+"
student["city"] = "Louisville"


for key, value in student.items():
  print(key, value)

student.keys()
student.values()
student.items()
student.get("key")