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
// 1. Fetch the instruction from the primary memory (RAM) or cache memory (L1, L2, L3)
// 2. Decode the instruction (convert the instruction into a set of operations)
// 3. Execute the instruction (perform the operations)
// 4. Store the result back in the memory

// In this example, we have 4 statements.
// all these statements will be converted into a set of instructions.
// The set of instructions means the bytecode (CPU.class) that is produced by the compiler.
// to see the bytecode, run the following command in the terminal:
// $ javap -verbose CPU.class or javap -c CPU.class
// CPU decodes the bytecode and executes the instructions.

// to see CPU details, run the following command in the terminal:
// $ lscpu OR cat /proc/cpuinfo

//CPU(s):                   8 // it means 8 cores are available in the CPU (4 physical cores and 4 logical cores) (4*2=8)
//On-line CPU(s) list:    0-7 // it means 8 cores are available in the CPU (0, 1, 2, 3, 4, 5, 6, 7)
//Vendor ID:                GenuineIntel // it means the CPU is Intel
//Model name:             Intel(R) Core(TM) i5-8250U CPU @ 1.60GHz
//CPU family:           6
//Model:                142
//Thread(s) per core:   2 // it means 2 threads are available in each core (4 * 2 = 8 CPUs)
//Core(s) per socket:   4 // it means 4 cores are available in each socket
//Socket(s):            1 // it means 1 socket is available in the CPU
//Caches (sum of all):
//L1d:                    128 KiB (4 instances) // L1d means Level 1 data cache (4 instances means 4 cores)
//L1i:                    128 KiB (4 instances) // L1i means Level 1 instruction cache (4 instances means 4 cores)
//L2:                     1 MiB (4 instances) // L2 means Level 2 cache (4 instances means 4 cores) (1 MiB = 1024 KiB) (4 * 1024 = 4096 KiB)
//L3:                     6 MiB (1 instance) // L3 means Level 3 cache (1 instance means 1 socket) (6 MiB = 6144 KiB)
