# SujalAssissment

<h2>
Prerequisite
</h2>
<ul>
<li>
GitBash
</li>
<li>
Java
</li>
<li>
IDE
</li>
</ul>
For using this repository, use the following command.

Git Clone:
git clone https://github.com/SujalSkya/SujalAssissment.git

<p>Open the cloned repository and open terminal in Intellij or other IDE.</p>

<p> Used tools : </p>
<ul>
        <li>
            Testng
        </li>
        <li>
            Maven
        </li>
        <li>
            Selenium 4
        </li>   
        <li>
            Extent report (For generating reports)
        </li>
</ul>
<p>
Use <code> mvn test -DsuiteXmlFile=TestSuites/subscriber.xml</code> command in terminal. This command will execute all the test
files present in the <b>Homepage</b> file which is verifying total subscriber.
</p>

<p>
Use <code> mvn test -DsuiteXmlFile=TestSuites/login.xml </code> command in terminal. This command will
execute all the test files present in the <b>login</b> class which are "Login (Positive & Negative)
scenario.
</p>

<p>
Use <code> mvn test -DsuiteXmlFile=testng.xml </code> command in terminal. This command will
execute all the test files present in the script classes which are "Login (Positive & Negative)
scenario & verifying total subscriber.
</p>

<p>
Once the script are executed successfully, a report is being generated which can be accessed
in <b>TestReports</b> folder. Simply open the file in any browser for better experience.
</p>
