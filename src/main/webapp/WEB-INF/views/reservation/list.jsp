<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des Réservations</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <header>
        <nav>
            <div class="logo">Front Office Location</div>
            <ul>
                <li><a href="${pageContext.request.contextPath}/">Accueil</a></li>
                <li><a href="${pageContext.request.contextPath}/reservations">Réservations</a></li>
                <li><a href="${pageContext.request.contextPath}/about">À propos</a></li>
            </ul>
        </nav>
    </header>

    <main>
        <section class="content">
            <div class="header-actions">
                <h1>Liste des Réservations</h1>
                <a href="${pageContext.request.contextPath}/reservations/new" class="btn btn-primary">Nouvelle Réservation</a>
            </div>

            <!-- Formulaire de filtre par date -->
            <div class="filter-section" style="margin-bottom: 20px; padding: 15px; background-color: #f5f5f5; border-radius: 5px;">
                <form method="get" action="${pageContext.request.contextPath}/reservations" style="display: flex; gap: 10px; align-items: center;">
                    <label for="dateFilter" style="margin: 0;">Filtrer par date:</label>
                    <input type="date" id="dateFilter" name="date" value="${selectedDate}" style="padding: 5px; border: 1px solid #ccc; border-radius: 3px;">
                    <button type="submit" class="btn btn-primary">Filtrer</button>
                    <a href="${pageContext.request.contextPath}/reservations" class="btn btn-secondary">Réinitialiser</a>
                </form>
            </div>

            <table class="table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Hotel ID</th>
                        <th>Client ID</th>
                        <th>Nombre de Passagers</th>
                        <th>Date/Heure</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="reservation" items="${reservations}">
                        <tr>
                            <td>${reservation.id}</td>
                            <td>${reservation.idHotel}</td>
                            <td>${reservation.idClient}</td>
                            <td>${reservation.nbPassager}</td>
                            <td>${reservation.dateHeure}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <c:if test="${empty reservations}">
                <div class="empty-state">
                    <p>Aucune réservation trouvée.</p>
                </div>
            </c:if>
        </section>
    </main>

    <footer>
        <p>&copy; 2026 Front Office Location. Tous droits réservés.</p>
    </footer>
</body>
</html>
