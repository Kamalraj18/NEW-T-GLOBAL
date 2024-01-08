from functionscall import get_file, write_file
#import functioncall

while True:
    user_action = input()

    match user_action:
        case 'add':
            todo = input() + "\n"

            todos = get_file()

            todos.append(todo)

            write_file(todos)

        case 'show':
            todos = get_file()
            new_todos = []

            for item in todos:
                new_todos.append(item.strip('\n'))

            for index, todo in enumerate(new_todos):
                print(f"{index}-{todo}")
        case 'exit':
            break
