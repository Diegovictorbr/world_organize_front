<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:pageTemplate titulo="World Organize">
    <nav id="menu" style="background: url('resources/images/bg1.png')">
        <a href="#" id="closeSlideRef">
            <i class="fas fa-times"></i>
        </a>

        <!-- TODO: logo circular da aplicação -->
        <div style="width: 100%; height: 100; background: url('resources/images/bg1.png')">
            <div id="header" class="text-center">
                <div>
                    <img class="rounded-circle" src="resources/images/profile.jpg" alt="User picture"
                         style="width: 150px; height: auto; border: 4px solid dimgray">
                    <br>
                    <h3 style="margin-top: 5%;color: dimgray;font-weight: bolder">World Organize</h3>
                    <hr style="border: none; height: 1px; color: dimgray; background-color: dimgray">
                </div>
            </div>

            <div id='cssmenu'>

                <ul>
                    <li><a href='#'>Home</a></li>

                    <li class='active has-sub'><a href='#'>Categorias</a>
                        <ul id="categories">
                        </ul>
                    </li>
                </ul>

            </div>
        </div>
    </nav>

    <div id="content">
        <input id="filterBtn" type="image" src="resources/images/menu.png" />
        <div id="mapContainer"></div>
    </div>

</tags:pageTemplate>