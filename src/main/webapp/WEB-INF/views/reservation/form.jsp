<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulaire Réservation</title>
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
            <h1>
                <c:choose>
                    <c:when test="${reservation.id != null}">Modifier la Réservation</c:when>
                    <c:otherwise>Nouvelle Réservation</c:otherwise>
                </c:choose>
            </h1>

            <c:set var="formAction" value="${reservation.id != null ? pageContext.request.contextPath.concat('/reservations/').concat(reservation.id) : pageContext.request.contextPath.concat('/reservations')}" />
            
            <form:form action="${formAction}" method="post" modelAttribute="reservation" cssClass="form">
                
                <div class="form-group">
                    <label for="clientName">Nom du Client</label>
                    <form:input path="clientName" id="clientName" required="required" cssClass="form-control" />
                    <form:errors path="clientName" cssClass="error" />
                </div>

                <div class="form-group">
                    <label for="clientEmail">Email</label>
                    <form:input path="clientEmail" id="clientEmail" type="email" required="required" cssClass="form-control" />
                    <form:errors path="clientEmail" cssClass="error" />
                </div>

                <div class="form-group">
                    <label for="clientPhone">Téléphone</label>
                    <form:input path="clientPhone" id="clientPhone" type="tel" cssClass="form-control" />
                    <form:errors path="clientPhone" cssClass="error" />
                </div>

                <div class="form-row">
                    <div class="form-group">
                        <label for="dateDebut">Date de Début</label>
                        <form:input path="dateDebut" id="dateDebut" type="date" required="required" cssClass="form-control" />
                        <form:errors path="dateDebut" cssClass="error" />
                    </div>

                    <div class="form-group">
                        <label for="dateFin">Date de Fin</label>
                        <form:input path="dateFin" id="dateFin" type="date" required="required" cssClass="form-control" />
                        <form:errors path="dateFin" cssClass="error" />
                    </div>
                </div>

                <div class="form-group">
                    <label for="status">Statut</label>
                    <form:select path="status" id="status" cssClass="form-control">
                        <form:option value="EN_ATTENTE">En attente</form:option>
                        <form:option value="CONFIRMEE">Confirmée</form:option>
                        <form:option value="ANNULEE">Annulée</form:option>
                        <form:option value="TERMINEE">Terminée</form:option>
                    </form:select>
                </div>

                <div class="form-group">
                    <label for="description">Description</label>
                    <form:textarea path="description" id="description" rows="4" cssClass="form-control" />
                </div>

                <div class="form-actions">
                    <button type="submit" class="btn btn-primary">Enregistrer</button>
                    <a href="${pageContext.request.contextPath}/reservations" class="btn btn-secondary">Annuler</a>
                </div>
            </form:form>
        </section>
    </main>

    <footer>
        <p>&copy; 2026 Front Office Location. Tous droits réservés.</p>
    </footer>
</body>
</html>
