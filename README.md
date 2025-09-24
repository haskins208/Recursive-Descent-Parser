# Recursive Descent Parser

A recursive descent parser, pretty-printer, and executor for a custom programming language.

## Project Overview

This project implements a full pipeline for a small, custom programming language including:

- Lexical analysis (tokenizer)  
- Parsing via recursive descent to build an Abstract Syntax Tree (AST)  
- A pretty printer to format/print source code  
- An executor to interpret and run the AST  
- Support for expression evaluation, control flow, and basic program execution

- **Language:** Java  
- **Design Techniques:** Recursive descent parsing, AST design  
- **Data Structures:** Trees, lists, and custom nodes  
- **I/O:** File reading for program input, console output  


1. Clone the repository:

   git clone https://github.com/haskins208/Recursive-Descent-Parser.git
   cd Recursive-Descent-Parser
   
2. Compile the source code:

javac -d bin src/**/*.java

3. Run the program with a sample input:

java -cp bin Main data/sample_program.txt
(Adjust Main and paths depending on your project’s entrypoint class and file structure.)

Example Input
Input (custom language syntax):

let x = 5;
if x > 0 then
   print(x);
else
   print(0);
end
