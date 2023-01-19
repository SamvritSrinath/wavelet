# Guide to using Github and Server
## Setting up Servers and URLHandler
Port Number shows the Port allocated to a server(between 1234 and 49531), servers have allocation for people to connect

`http://ieng6-20x.ucsd.edu:PortNum` where x is the machine you were allocated and the PortNum is the port number allocated to you.

Changes to the server will be reflected on the URLHandler. However, the Port Number could already be in use, but any Port Number should be fine :D. 
Objects are stored in the heap and this Object is stored client side

for a link 
`http://ieng6-20x.ucsd.edu:PortNum/command?searchquery` 

the  **Search Query** Is the search query that is being sent to the server. after the question mark in the link. the domain is the server so:

`ieng6-20x.ucsd.edu` 

There are three cases when delpoying the server:
When you are at the home page you should check:

	if (url.getPath().equals("/")) {
		return String.format("Samvrit's number: %d", num);
	}
This is what the User will see on the home page

Then if you have any specific commnands with search queries: 
	
	if (url.getPath().equals("/command")) {
		String[] parameters = url.getQuery().split("="); //Equals to check
			if (parameters[0].equals("count")) {//Check if the search query is valid
				//Do Stuff
			}
	}

Otherwise: if no cases are valid: 

	return "404 Not Found";

This Handling requests should be in a seperate class called: **Handler**

### Code for the Server:
	public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
## **Reference: Github**

General Process: `git pull` -> `git checkout` -> `git add` -> `git commit` -> `git push`
### **Contributing to an existing repository**

	git clone https://github.com/owner/repo.git
	//change into the `repo` directory
	cd repo
	# create a new branch to store any new changes
	git branch my-branch
	# switch to that branch (line of development)
	git checkout my-branch
	# make changes, for example, edit `file1.md` and `file2.md` using the text editor
	# stage the changed files
	git add file1.md file2.md
	# take a snapshot of the staging area (anything that's been added)
	git commit -m "my snapshot"
	# push changes to github
	git push --set-upstream origin my-branch

### **Starting a Repository**
	# create a new directory, and initialize it with git-specific functions
	git init my-repo

	# change into the `my-repo` directory
	cd my-repo

	# create the first file in the project
	touch README.md

	# git isn't aware of the file, stage it
	git add README.md

	# take a snapshot of the staging area
	git commit -m "add README to initial commit"

	# provide the path for the repository you created on github
	git remote add origin https://github.com/YOUR-USERNAME/YOUR-REPOSITORY-NAME.git

	# push changes to github
	git push --set-upstream origin main

### **Contributing to a branch**
	# change into the `repo` directory
	cd repo

	# update all remote tracking branches, and the currently checked out branch
	git pull

	# change into the existing branch called `feature-a`
	git checkout feature-a

	# make changes, for example, edit `file1.md` using the text editor

	# stage the changed file
	git add file1.md

	# take a snapshot of the staging area
	git commit -m "edit file1"

	# push changes to github
	git push