# FollowMouse
An image following the mouse pointer by basic vector math.

To make this work all you have to do is add these files to your project and activate the FollowScreen. So your initial class in the core project should look like this:

```java
public class YourProject extends Game {
	@Override
	public void create () {
        this.setScreen(new FollowScreen());
	}
}
```

Here is a image to visualize what I do in this example:
![vector math](http://i.imgur.com/Ah6UhVQ.png)

You can change the texture to anything you want, perhaps an arrow so it actually represents an arrow. Now it's BadLogic vs Mouse.
