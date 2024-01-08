while True:
    user_action = input()
    
    match user_action:
        case 'add':
            todo = input() + "\n"
            file = open('todo.txt', 'r')
            todos = file.readlines()
            file.close()
            todos.append(todo)

            file = open('todo.txt', 'w')
            file.writelines(todos)
            file.close()
        case 'show':
            file = open('todo.txt', 'r')
            todos = file.readlines()
            file.close()

            new_todos = []

            for item in todos:
                new_todos.append(item.strip('\n'))

            for index, todo in enumerate(new_todos):
                print(f"{index}-{todo}")
        case 'exit':
            break
    
    
            
        
    
