#Task 1
def validate_password(password):
  # checks password 
  # at least 8 characters long
  # at least one upper/lowercase letter
  # contain at least one digit
  # contain at least one special character

  special_characters = "!@#$%^&*"
  errors = []

  if len(password) < 8:
        errors.append("password must be at least 8 characters long")

  if not any(p.isupper() for p in password):
        errors.append("password must contain at least one uppercase letter")

  if not any(p.islower() for p in password):
        errors.append("password must contain at least one lowercase letter")

  if not any(p.isdigit() for p in password):
        errors.append("password must contain at least one digit")

  if not any(p in special_characters for p in password):
        errors.append("password must contain at least one special character")

  return {"valid": len(errors) == 0, "errors": errors}

if __name__ == "__main__":
    
  #Test Cases for Task 1
  print(validate_password("Abc123!x"))
  print(validate_password("abc"))
  print(validate_password("ABCDEFGH"))
  print(validate_password("ABCDefgh1!"))