# Java-Logical-Expression-Validator
This Java class evaluates logical arguments and determines whether they are valid or invalid based on a series of premises and a conclusion.

## Usage
To use the Logical Argument Evaluator, follow these steps:

Instantiate the Validator class.
Set the premises and conclusion of the argument using appropriate methods.
Call the validate() method to evaluate the argument.
The validate() method will return a boolean value indicating whether the argument is valid (true) or invalid (false).
```java
Copy code
// Instantiate the LogicalArgumentEvaluator
Validator evaluator = new Validator();

// Set the premises and conclusion of the argument
premises = {"Premise 1", "Premise 2", "Premise 3"};
conclusion "Conclusion"

// Evaluate the argument
boolean isValid = evaluator.validate(premises, conclusion);

// Print the result
if (isValid) {
    System.out.println("The argument is valid.");
} else {
    System.out.println("The argument is invalid.");
}
```
Example
Here's an example that demonstrates the usage of the Logical Argument Evaluator:

```java
Copy code
public class Main {
    public static void main(String[] args) {
        // Instantiate the LogicalArgumentEvaluator
        Validator evaluator = new Validator();

        // Set the premises and conclusion of the argument
        premises = {"p", "pVq", "r^q"}
        conclusion = "r"
        

        // Evaluate the argument
        boolean isValid = evaluator.validate(premises, conclusion);

        // Print the result
        if (isValid) {
            System.out.println("The argument is valid.");
        } else {
            System.out.println("The argument is invalid.");
        }
    }
}
```
In this example, the premises state that all men are mortal and Socrates is a man. The conclusion asserts that Socrates is mortal. Running the code will output "The argument is valid." since the argument follows a valid logical form.
