import random
# Task 3 
def guessing_game():
  answer = random.randint(1, 100)
  max_attempts = 7
  attempts = 0

  
  while attempts < max_attempts:
    try:
      user_input = int(input("Guess a number (1-100): "))
    except ValueError:
      # reject anything that isn't a whole number
      print("Invalid input. Please enter a number.")
      continue
    attempts += 1

    if user_input == answer:
      print(f"Congrats! {attempts} attempts were used")
      return True
    elif user_input < answer:
      print(f" Too low. {max_attempts - attempts} attempts left.")
    else:
      print(f" Too High. {max_attempts - attempts} attempts left.")

  # only reached if the user has used all attempts  
  print(f"Out of attempts. the answer was {answer}.")
  return False

if __name__ == "__main__":
  guessing_game()


    
  
