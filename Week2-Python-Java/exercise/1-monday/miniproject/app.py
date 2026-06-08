from flask import Flask, request, jsonify

app = Flask(__name__)

students = [
    {"id": 1,"name": "Alice","course": "Computer Science"},
    {"id": 2,"name": "Jett","course": "Data Science"}
]
# Display all students
@app.route("/students", methods=["GET"])
def get_all_students():
    return jsonify(students)

# Displays a single student
@app.route("/students/<int:student_id>", methods=["GET"])
def get_student(student_id):
    student = next((s for s in students if s["id"] == student_id), None)
    if student:
        return jsonify(student)
    return jsonify({"error":"student not found"}), 404

# Add a new student
@app.route("/students", methods = ["POST"])
def create_student():
    data = request.get_json() # gets json body from postman
    new_student = {
        "id": students[-1]["id"] + 1 if students else 1,
        "name": data.get("name"),
        "course": data.get("course")
    }

    students.append(new_student)
    return jsonify(new_student), 201

# Update a student
@app.route("/students/<int:student_id>", methods = ["PUT"])
def update_student(student_id):
    data = request.get_json()
    student = next((s for s in students if s["id"] == student_id), None)
    if student:
        student["name"] = data.get("name", student["name"])
        student["course"] = data.get("course", student["course"])
        return jsonify(student)
    return jsonify({"error":"student not found"}), 404

# Delete a student
@app.route("/students/<int:student_id>", methods=["DELETE"])
def delete_student(student_id):
    global students
    students = [s for s in students if s["id"] != student_id]
    return jsonify({"message": "student deleted"}), 200



if __name__ == "__main__":
    app.run(debug=True)