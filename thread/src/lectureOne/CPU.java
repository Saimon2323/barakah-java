package lectureOne;

/**
 * @Author Muhammad Saimon
 * @since Nov 10, 2024 8:52 AM
 */

public class CPU {
    public static void main(String[] args) {
        int a = 10; // Statement
        int b = 20; // Statement
        int c = a + b; // Statement
        System.out.println("c = " + c); // Statement
    }
}

// CPU: Central Processing Unit
// CPU is the brain of the computer.
// CPU executes the instructions.
//  - (Programs are a set of instructions)
//  - (Instructions are a set of statements)
//  - (Statements are a set of expressions)
//  - (Expressions are a set of variables and operators)

// CPU works in the following way:
// 1. Fetch the instruction from the memory
// 2. Decode the instruction
// 3. Execute the instruction
// 4. Store the result back in the memory

// In this example, we have 4 statements.
// all these statements will be converted into a set of instructions.
// The set of instructions means the bytecode (CPU.class) that is produced by the compiler.
// to see the bytecode, run the following command in the terminal:
// $ javap -verbose CPU.class or javap -c CPU.class
// CPU decodes the bytecode and executes the instructions.