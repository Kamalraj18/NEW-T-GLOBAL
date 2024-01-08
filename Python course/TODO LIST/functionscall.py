import time


def get_file():
    with open('todo.txt', 'r') as file:
        todos = file.readlines()
    return todos


def write_file(todos1):
    with open('todo.txt', 'w') as file:
        # now = time.strftime("%b %d, %Y %H:%M:%S" + "\n")
        # file.writelines(now)
        file.writelines(todos1)


def get_todo():
    todos = get_file()
    new_todos = []
    for item in todos:
        new_todos.append(item.strip('\n'))
    return new_todos

