date = input("date: ")
rating = input()
thoughts = input("let me know your thoughts: ")

with open(f"{date}", "w") as file:
    file.write(rating + 1 * "\n")
    file.write(thoughts)
