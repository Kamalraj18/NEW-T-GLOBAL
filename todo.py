todos = []

while True:
    user_action = input()
    
    match user_action:
        case 'add':
            todo_input = input()
            todos.append(todo_input)
        case 'show':
            for index, todo in enumerate(todos):
                print(f"{index}-{todo}")
        case 'exit':
            break
    
    
            
        
    
