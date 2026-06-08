from flask import Flask, request
app = Flask(__name__)

@app.route("/")
def home():
  return "Hello Flask"

@app.route("/about")
def about():
  return "About Page"

@app.route("/contact")
def contact():
  return "Contact Page"

# url parameter -- path parameter
# /user/<name>
@app.route("/user/<name>")
def user_name(name):
  return f"Hello {name} !"

#Query string
# /user?name=<name>
@app.route("/user1")
def user1_name():
  name = request.args.get("name")
  return f" Hello {name} !!!"

@app.route("/user2")
def user2_name():
  name = request.args.get("name")
  role = request.arges.get("role")
  return f"Hello {name}, "

@app.route("/add/<int:num1>/<int:num2>")
def sum(num1,num2):
  return f"{num1} + {num2} = {num1 + num2}"

if __name__ == "__main__":
    app.run(debug=True)