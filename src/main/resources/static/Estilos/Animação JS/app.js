var btnSignin = document.querySelector("#signin");
var btnSignup = document.querySelector("#signup");
var body = document.querySelector("body");

btnSignin.addEventListener("click", function () {
    body.className = "sign_in_js";
});

btnSignup.addEventListener("click", function () {
    body.className = "sign_up_js";
});

function recuperarSenha(params) {
    if (params === "exibir") {
        document.getElementsByClassName("label_input")[5].style.display = "none";
        document.getElementsByClassName("descricao descricao_cinza")[1].style.display = "none";
        document.getElementsByClassName("list_social_midia")[1].style.display = "none";
        document.getElementsByClassName("titulo_padrao titulo_verde")[1].innerHTML = "Digite seu e-mail";
        document.getElementsByClassName("btn_login btn_secundario")[1].innerHTML = "RECUPERAR";
        document.getElementsByClassName("senha")[0].innerHTML = "Voltar";
        document.getElementsByClassName("senha")[0].setAttribute("onClick", "javascript: recuperarSenha('fechar')");
    } else if (params === "fechar") {
        document.getElementsByClassName("label_input")[5].style.display = "flex";
        document.getElementsByClassName("descricao descricao_cinza")[1].style.display = "flex";
        document.getElementsByClassName("list_social_midia")[1].style.display = "flex";
        document.getElementsByClassName("titulo_padrao titulo_verde")[1].innerHTML = "Entrar em sua Conta";
        document.getElementsByClassName("btn_login btn_secundario")[1].innerHTML = "ENTRAR";
        document.getElementsByClassName("senha")[0].innerHTML = "Esqueceu sua senha?";
        document.getElementsByClassName("senha")[0].setAttribute("onClick", "javascript: recuperarSenha('exibir')");
    } else {
        alert("E-mail de recuperação de senha enviado!");
        recuperarSenha('fechar');
    }
}

// function recuperarSenha(param) {
//     let modal = document.querySelector('.modal_senha_esquecida');
//     if (param === "abrir") {
//         modal.style.display = 'flex';
//     } else if (param === "fechar") {
//         modal.style.display = 'none';
//     } else {
//         alert("Um e-mail de recuperação de senha foi enviado.")
//         modal.style.display = 'none';
//     }
// }