# SpringMVCFilmCRUD

<!-- PROJECT LOGO -->

<!-- TABLE OF CONTENTS -->

<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#technologies-used">Technologies Used</a></li>
      </ul>
    </li>
  <ul>
    <li><a href="#howitworks">How It Works</a></li>
  </ul>  
  <ul>
    <li><a href="#contact">Contact</a></li>
  </ul>

  <ul>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
    </ul>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->

## About The Project

<p>SpringMVCFilmCRUD is a Dynamic Web Application that allows the user to perform the following operations on a Film in the SD MYSQL Film Database.</p>
<ol>
<li><strong><em>C</em></strong>reate - Create a new Film in the database with the "Add A Film" Button</li>
<br>
<li><strong><em>R</em></strong>ead - View the current information for a Film in the database</li>
<br>
<li><strong><em>U</em></strong>pdate - Update Predefined Fields of a Film in the database</li>
<br>
<li><strong><em>D</em></strong>elete - Remove Existing Films in the database</li>
</ol>
<!--[![Product Name Screen Shot][product-screenshot]](https://example.com) -->

<p align="right">(<a href="#top">back to top</a>)</p>

### Technologies Used

-   [Spring Tools 4](https://spring.io/tools)
-   [Gradle Build Tool](https://gradle.org/install/)
-   [MAMP Free](https://www.mamp.info/en/mac/)
-   [Apache Tomcat v8.5](https://tomcat.apache.org/)
-   [MySQL](https://www.mysql.com/)
-   [Atom Text Editor](https://atom.io/)
-   [Bootstrap v5.1](https://getbootstrap.com)

<p align="right">(<a href="#top">back to top</a>)</p>

## How It Works

<ol>
<li>
The MVCFilmSite Dynamic Web App is Run on a Apache Tomahawk v8.5 server and launched through Spring Tool Suite 4
</li>
<li>
Upon Launch we are brought to Home Page reflected in /WEB-INF/home.jsp
</li>
<li>
<strong>Find Film By Id</strong> navigates to <strong>findFilmById.html</strong> where the user is prompted for the Film Id they would like to retrieve from the database.
</li>
<ul>
<li>All information for the requested Film is then retrieved by way of the SpringMVC provided getFilmData.do RequestMapping found in the FilmController.java
</li>
<li>User is then prompted with Two options for the displayed Film</li>
  <ol>
    <li>Delete Film</li>
      <ul>
        <li>The selected film is removed from the database by way of the SpringMVC provided deleteFilm.do RequestMapping found in the FilmController.java and user is returned to the aforementioned homepage at /WEB-INF/home.jsp</li>
      </ul>
    <li>Update Film</li>
      <ul>
        <li>
        The selected film is displayed for editing through updateFilm.html with the current values shown</li>
        <li>
        User can then change all given fields to their preferred input and apply them to the database by way of the SpringMVC provided updateFilm.do RequestMapping found in the FilmController.java and then user is returned to the aforementioned homepage at /WEB-INF/home.jsp
        </li>
      </ul>
  </ol>

</ul>
<li>
<strong>Add A Film</strong> navigates to <strong>addFilm.html</strong> where the user is prompted to enter the Film's Title, Description, Release Year, Rating, and Length
</li>
  <ul>
    <li>
    When user selects the Submit button all inputed fields are added to the database by way of the SpringMVC provided addFilm.do RequestMapping found in the FilmController.java and then user is returned to the aforementioned homepage at /WEB-INF/home.jsp
    </li>
  </ul>
</ol>

<p align="right">(<a href="#top">back to top</a>)</p>

## Contact

<strong>Developers on Project</strong>

<h4>Anthony Butler</h4>

<ul>
<li><a href="http://www.linkedin.com/in/anthony-tyler-butler">LinkedIn</a></li>
<li><a href="anthonybutler0824@gmail.com">E-mail</a></li>
<li><a href="https://github.com/anthonyb0824">Github</a></li>
</ul>

<h4>Cecelia Guerrero</h4>

<ul>
<li><a href="https://www.linkedin.com/in/cecelia-guerrero/">LinkedIn</a></li>
<li><a href="guerrero.a.cecelia@gmail.com"</a>E-mail</li>
<li><a href="https://github.com/Cagugu">Github</a></li>
</ul>

<h4>Andrew Cornelius</h4>
<ul>
<li><a href="https://www.linkedin.com/in/andrew-cornelius-584b151a9">LinkedIn</a></li>
<li><a href="acorneld@gmail.com">E-mail</a></li>
<li><a href="https://github.com/acorneld">Github</a></li>
</ul>

Project Link: [SpringMVCFilmCRUD](https://github.com/acorneld/SpringMVCFilmCRUD)

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- ACKNOWLEDGMENTS -->

## Acknowledgments

-   [GitHub Emoji Cheat Sheet](https://www.webpagefx.com/tools/emoji-cheat-sheet)
-   [Malven's Flexbox Cheatsheet](https://flexbox.malven.co/)
-   [Malven's Grid Cheatsheet](https://grid.malven.co/)
-   [GitHub Pages](https://pages.github.com)
-   [Font Awesome](https://fontawesome.com)
-   [React Icons](https://react-icons.github.io/react-icons/search)

<p align="right">(<a href="#top">back to top</a>)</p>
