## Conventions in code ##

We stick strictly to the Java Code Conventions:
http://www.oracle.com/technetwork/java/codeconv-138413.html

When writing OpenGL code, you should also observe the following practices:
  1. You must indent blocks of code, such as glBegin() and glEnd(), glPushMatrix() and glPopMatrix(), display lists code, and so on.
> > Take extra care with your IDE auto-format functions, since they will break this indentations;
  1. You must statically import all OpenGL and OpenAL classes such as GL11 and GLU. If you are using eclipse, configure the import static number for this project to 5;
  1. Use the formatter and code templates of eclipse project folder.

We also adopt the following code practices:

1. Use code-guards check the conditions and leave the function immediately. This also avoid excessive indentation:

BAD:
```
 boolean processEnemy() {
   if (isEnemy) {
      processEnemyInput();
      processEnemyAI();
      testEnemyDeath();
   }
   return isEnemy;
 }
```

GOOD:
```
 boolean processEnemy() {
   if (!isEnemy) {
      return false;
   }
   
  processEnemyInput();
  processEnemyAI();
  testEnemyDeath();
  return true;
 }
```

2. Avoid redundant ifs and elses (see java code conventions 10.5.2):

BAD:
```
if (condition) {
   return false;
} else {
   return true;
}
```
GOOD:
```
return !condition;
```

3. Avoid redundant "this" declarations:

BAD:
```
if (this.area() < this.size() * this.size()) {
   this.doSomething();
}
```

GOOD:
```
if (area() < size() * size()) {
   doSomething();
}
```

4. When writing interfaces, avoid redundant access modifiers.
BAD:
```
public interface SomeInterface {   
   public void someMethod();
}
```

GOOD:
```
public interface ImageLoader {   
   void someMethod();
}
```

5. We strongly suggest to turn on all "Unnecessary code" Eclipse warnings, except for parameter verification and exception warnings.

6. Do not leave code with warnings. All warnings must be fixed. Also, try to organize imports after finishing your and apply the code formatter (take care if you use opengl since this could break your opengl formatting);

## Javadoc and comments ##

1. All methods must have relevant javadocs, written in american english. Try to make an extensive but rational use of javadoc tags, just like Sun did in java API javadocs. Remember to specify measure units, exceptions or other non-obvious conditions, if needed;

2. Avoid blank javadoc methods. Let Eclipse include trivial and obvious javadocs like:
```
/** Sets x value. */
public void setX(float x) {
  this.x = x;
}

/** @return The x value. */
public float getX() {
   return x;
}
```

3. If you are a class Author or main contributor, write your full name in the class description, under the @author tag. Use your complete name, not a nickname or just your initials. You may use the initials for your middle names, and you may write your nick name after your name, enclosed by parenthesis.

BAD:
mhitchhiker

GOOD:
Johnathan R. Doe (mhitchhiker)

4. Do NOT add your name in classes that you just made minor corrections or just wrote some minor utility methods (if you just did this, you're NOT a main contributor for this class);

5. NEVER remove Author names. Even if you overhauled the entire class implementation with new ultra-optimized methods, the original author still wrote the basic class concept, so, keep his name and append your name after his;

6. Include comments in optimized methods;

7. Avoid multiline comments, except for the top license information comment that is included eclipse subfolder. If you are writing several line of comments, consider refactoring your class;

8. Avoid humorous, childish or self-congratulatory javadocs. Comments should be technical, not a commercial ad

BAD
This method do some impressive optimizations with a very innovative algorithm. By using it, you'll have good quality features with extreme gain.

GOOD
This method was optimized with an implementation based on Belmann-Ford algorithm, with modifications. By using it, you'll expect a linear time, instead of the exponential time found in the naïve approach.

9. Do NOT use javadocs to promote your blog, website or anything else.