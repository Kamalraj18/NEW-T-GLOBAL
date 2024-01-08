import json

with open("files/quiz.json", 'r') as file:
    content = file.read()

data = json.loads(content)

for question in data:
    print(question["questions"])
    for index,options in enumerate(question["alternatives"]):
        print(index +1,"-",options)
    user_choice = int(input("Enter ur options: "))
    if user_choice == question["correct_ans"]:
        print("correct answer")
    else:
        print("Wrong answer")
