<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="modal fade" id="agregarKartModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Kart</h5>
                <button class="close" data-dismiss="modal"> <span>&times;</span> </button>
            </div>

            <form action="${pageContext.request.contextPath}/kart?action=insert" method="POST" class="was-validated">

                <div class="modal-body">
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" name="nombre" required />
                    </div>
                    <div class="form-group">
                        <label for="tipo">Tipo</label>
                        <select id="tipo" name="tipo" class="form-control">
                            <option selected>BASIC</option>
                            <option>E_KART</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="precio">Precio por minuto</label>
                        <input type="number" class="form-control" name="precio" step=".01" required>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button>
                </div>
            </form>
        </div>
    </div>
</div>
