# Task 2
def fizzbuzz(n):
  if n % 3 == 0 and n % 5 == 0 and n % 7 == 0:
      print("FizzBuzzBoom")
  elif n % 3 == 0 and n % 5 == 0:
      print("FizzBuzz")
  elif n % 3 == 0 and n % 7 == 0:
      print("FizzBoom")
  elif n % 5 == 0 and n % 7 == 0:
      print("BuzzBoom")
  elif n % 3 == 0:
      print("Fizz")
  elif n % 5 == 0:
      print("Buzz")
  elif n % 7 == 0:
      print("Boom")
  else:
      print(n)

if __name__ == "__main__":
  
  (fizzbuzz(105)) 