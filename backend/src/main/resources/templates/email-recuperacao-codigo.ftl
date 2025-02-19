<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro Loja MB - Preparações</title>
    <style>
        /* Estilos básicos para o corpo do e-mail */
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
            color: #333333;
        }
        /* Container principal do e-mail */
        .email-container {
            max-width: 600px;
            margin: 20px auto;
            background-color: #ffffff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
        }
        /* Estilo para a imagem */
        .header-image {
            width: 100%;
            max-width: 100%;
            height: auto;
            border-radius: 8px;
            margin-bottom: 20px;
        }
        /* Estilo para o título */
        h3 {
            color: #2c3e50;
            margin-bottom: 20px;
            font-size: 24px;
            font-weight: bold;
        }
        /* Estilo para parágrafos */
        p {
            line-height: 1.6;
            margin: 15px 0;
            font-size: 16px;
            color: #555555;
        }
        /* Estilo para o botão */
        .button {
            display: inline-block;
            padding: 12px 24px;
            margin: 20px 0;
            background-color: #007bff;
            color: #ffffff;
            text-decoration: none;
            border-radius: 5px;
            font-size: 16px;
        }
        /* Rodapé do e-mail */
        .footer {
            margin-top: 30px;
            padding-top: 20px;
            border-top: 1px solid #eeeeee;
            text-align: center;
            font-size: 14px;
            color: #777777;
        }
        .footer p {
            margin: 5px 0;
        }
    </style>
</head>
<body>
<div class="email-container">
    <!-- Imagem no topo do e-mail -->
    <img src="https://drive.google.com/uc?export=view&id=1nU5ClXhnP3jfsKMOn2_i8XuWBJzFzymp" alt="Banner MB-Preparações" class="header-image">

    <h3>Olá, ${nome}</h3>
    <p>${mensagem}</p>
    <p>Se você não solicitou um cadastro, por favor, ignore este e-mail.</p>
    <div class="footer">
        <p>Atenciosamente,</p>
        <p>Equipe MB-Preparações</p>
    </div>
</div>
</body>
</html>