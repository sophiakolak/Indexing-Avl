# Student README file

## Compiling and Running 
* to check the postfix expressions, change the hardcoded value in Problem1 
* to use the FileAvl, give a text file to Problem2 in the command line. 
## Implementing Expression Trees
1. `ExpressionTree.java`
this class takes in a postfix expression and runs the stack 
based algorithm to create an expression tree. Once the tree
is created, the following methods can be used on it
* `eval()`: private-takes in the root and checks if the token is a operator. If it is, then the expression gets computed. Then the value is returned to the public eval method. 
* `postfix()`: private-takes in the root. If the token is an operator, the string gets re-arranged into posfix order.
* `prefix()`: private-takes in the root. If the token is an operator, the string gets re-arranged into prefix order.
* `infix()`: private-takes in the root. If the token is an operator, the string gets re-arranged into infix order.
* `isInteger`: makes the creation of the expression tree easier. Since java already has many ways of deciding if data is an integer, I figured it was easier to construct this simple method than to keep checking if tokens were operators.
2. `Problem1.java`
* uses all of the aformentioned methods except isInteger (which is used implicitly) on the postfix expression given in class. The string is manually typed into the constructor for the expression tree object. 
## Indexing Text with an AVL tree
1. `FileAvl.java`
* main method reads through a text file. If no file is given or the file does not exist, an error is thrown. Otherwise, the text is processed. Each line becomes a string. Then we tokenize the string, and make everything lowercase so that case does not affect word storage. Finally, for each word not already in the Avl tree that is enocuntered, it gets added to an avl tree along with the line number that it appears in.
* `indexWord` public passes the given tree, word, and line
* `indexWord` private takes in the tree, word, and line, and then calls the insert method (defined in AvlTree) on that tree to add the word and line to that tree. 
* `getLinesForWord` public passes the word to private 
* `getLinesForWord` calls 'findLine' (defined in AvlTree) and passes that method the word in question. 
* `printIndex` public passes the tree to the private method 
* `printIndex` private calls the printTree method (defined in AvlTree) on the tree that it was passed.
2. `AvlTree.java`
* general: this class was modified to work for indexing words. Since the original class stored generic nodes, I could modify each node to instead store one string and one linkedlist.
* Node class: I gave this another instance variable (lineNumber) that was a linkedList
* `insert` the public method takes in the word and line number and passes it (+the root) to the private method. The private method. The private method then calls compare to on all the data. Eventually the string is either found or not. If found, it is not inserted. If not found it is added where it belongs. 
* `findLine` the public method checks if the word is contained in the tree. If yes, it passes the word to the private method which has the root. The private method then retreives the linked list associated with the node and returns it to the public method. Now the public method simply prints out the values in the linkedList which are the line numbers where the given word appears 
* `printTree` public checks if tree is emtpy. If not, calls private. Private prints in order (alphabetical in this case) by moving from left to right through the tree
3. `Problem2.java` simply creates an AvlFile instance and then calls the defined methods on it. 