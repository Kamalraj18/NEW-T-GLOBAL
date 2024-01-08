import PySimpleGUI as gui

add_file = gui.Text("Select Files to zip")
input1 = gui.Input()
select1 = gui.FileBrowse("Open")

dest_file = gui.Text("Select Files to zip")
input2 = gui.Input()
select2 = gui.FolderBrowse("Open")

ok = gui.Button("Compress")
cancel = gui.Button("Cancel")

window = gui.Window("File Compressor", layout=[[add_file, input1, select1], [dest_file, input2, select2],[ok,cancel]])
window.read()
window.close()
