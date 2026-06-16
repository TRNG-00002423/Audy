result

# in java exception handling revolves around 4: try,catch, finally, throw, throws
# python: try, except, else, and finally

#try block - problematic code
#except block - if exception occurs,
# finally - always called despite -- clean up the object in try block

try:
  # code that might raise an exception
  result = int(input("Enter a Number : "))
except ValueError:
  # if a value error occurs
  print("That is not a number")
  raise ZeroDivisionError("Some Text")
except (TypeError, KeyError) as e:
  # Catch multiple exception types
  print(f"Error: {e}")
else:
  # Runs only if NO exception occurred
   print(f"You entered: {result}")
finally:
  # ALWAYS runs — whether exception occurred or not
  print("Cleanup complete.")


  # bank App
  # -- deposit
  # -- withdraw

  # balance = 500
  # withdraw(700)