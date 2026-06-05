def my_decorator(func):
  def wrapper():
    print("Before Function Call....")
    func()
    print(" After Function Call")
  return wrapper

@my_decorator
def greet():
  print("Greet !")

greet()

@my_decorator
def hello():
  print("Hello !")
