# Deep Thought

Deep thought is a library for making command line utilities in Java. It is inspired by Thor (http://whatisthor.com/) which is a similar library for Ruby.

In order to user Deep Thought (hereafter 'dt') you need a modern (11+) jdk installation, or be able to run a docker image.

Dt is a library that makes it easy to write command line utilities in Java. To add functionality in dt, you'll need a class in the classpath that:
 - Has an empty constructor
 - Extends Task
 - Implements getUsage (so you know how to use it)
 - Implements getNames (a list of commands to reference this class)

In general, the fastest way to get started is:
1. Copy an existing class that extends Task to a new class name.
2. Change the NAMES and USAGE for the new task.
3. Implement the doit functionality.

After building a couple of utilities you'll find that it's easier to put common functionality (http client, db connections) into a utility class outside of the deepthought, so you can reuse it for different tasks.

Dt comes with a couple of examples:
Ls.java - prints out an ls command from the working directory
Echo.java - echos the command line

The Task class also has a public executeProcess function.  It takes a list of strings, which requires a path (/usr/bin/ls instead of ls) and returns the output.

Java Operation
Clone the repo, build, and run 'dt help'.  

Docker Operation
Run the command
docker run -it ????
-----
"We are the ones who will hear," said Phouchg, "the answer to the great question of Life....!"

"The Universe...!" said Loonquawl.

"And Everything...!"

...

"Though I don't think," added Deep Thought. "that you're going to like it."

- Dougless Adams, HHG2G
