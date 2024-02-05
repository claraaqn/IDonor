from flask import Flask, jsonify, request
import mysql.connector
import firebase_admin
from firebase_admin import credentials

app = Flask(__name__)

cred = credentials.Certificate("") # colocar aqui quando chaylane mandar o arquivo
firebase_admin.initialize_app(cred)

db = mysql.connector.connect(
    host="127.0.0.1",
    user="root",
    password="proghell17@!",
    database="iDonor")

# para pegar um doador já existente
@app.route('/doadores', methods=['GET'])
def get_doadores():
    cursor = db.cursor(dictionary=True)
    cursor.execute("SELECT * FROM doadores")
    doadores = cursor.fetchall()
    return jsonify(doadores)


# para criar um doador
@app.route('/doadores', methods=['POST'])
def criar_doadores():
    data = request.json
    nome = data.get('nome')
    email = data.get('email')
    senha = data.get('senha')
    data_de_nascimento = data.get('data_de_nascimento')
    telefone = data.get('telefone')
    localizacao = data.get('localizacao')

    cursor = db.cursor()
    cursor.execute("INSERT INTO doadores (nome, data_de_nascimento, email, telefone, senha, localizacao) VALUES (%s, %s, %s, %s, %s, %s)",
                   (nome, data_de_nascimento, email, telefone, senha, localizacao))
    db.commit()

    return jsonify(message="Usuário criado com sucesso"), 201

@app.route('/login', methods=['POST'])
def login():
    data = request.json
    email = data.get('email')
    senha = data.get('senha')

    cursor = db.cursor()
    cursor.execute("SELECT * FROM usuarios WHERE email = %s AND senha = %s", (email, senha))
    usuario = cursor.fetchone()

    if usuario:
        return jsonify(message="Login bem-sucedido"), 200
    else:
        return jsonify(error="Credenciais inválidas"), 401

if __name__ == '__main__':
    app.run(debug=True)