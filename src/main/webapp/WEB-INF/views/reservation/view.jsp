<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Détails Réservation</title>
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
            <h1>Détails de la Réservation #${reservation.id}</h1>

            <div class="card">
                <div class="card-body">
                    <div class="detail-row">
                        <strong>Client:</strong>
                        <span>${reservation.clientName}</span>
                    </div>
                    <div class="detail-row">
                        <strong>Email:</strong>
                        <span>${reservation.clientEmail}</span>
                    </div>
                    <div class="detail-row">
                        <strong>Téléphone:</strong>
                        <span>${not empty reservation.clientPhone ? reservation.clientPhone : 'Non renseigné'}</span>
                    </div>
                    <div class="detail-row">
                        <strong>Date de Début:</strong>
                        <span>${reservation.dateDebut}</span>
                    </div>
                    <div class="detail-row">
                        <strong>Date de Fin:</strong>
                        <span>${reservation.dateFin}</span>
                    </div>
                    <div class="detail-row">
                        <strong>Statut:</strong>
                        <span class="badge badge-${reservation.status.toLowerCase()}">${reservation.status}</span>
                    </div>
                    <c:if test="${not empty reservation.description}">
                        <div class="detail-row">
                            <strong>Description:</strong>
                            <p>${reservation.description}</p>
                        </div>
                    </c:if>
                    <div class="detail-row">
                        <strong>Créée le:</strong>
                        <span>${reservation.createdAt}</span>
                    </div>
                    <div class="detail-row">
                        <strong>Modifiée le:</strong>
                        <span>${reservation.updatedAt}</span>
                    </div>
                </div>
            </div>

            <div class="actions">
                <a href="${pageContext.request.contextPath}/reservations/${reservation.id}/edit" class="btn btn-primary">Modifier</a>
                <a href="${pageContext.request.contextPath}/reservations" class="btn btn-secondary">Retour à la liste</a>
            </div>
        </section>
    </main>

    <footer>
        <p>&copy; 2026 Front Office Location. Tous droits réservés.</p>
    </footer>
</body>
</html>
