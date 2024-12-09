import tkinter as tk
from tkinter import messagebox

# Variáveis globais para armazenar os resultados
resultado_MA = 0  # Resultado da média semestral
resultado_MF = 0  # Resultado da média final


def calcular_media_semestral():
    """Calcula a media semestral (MS) com base nas notas do NP1 e NP2."""
    global resultado_MA
    try:
        np1 = float(entry_np1.get())
        np2 = float(entry_np2.get())
        resultado_MA = (np1 + np2) / 2
        label_resultado_MA["text"] = f"Resultado Media Semestral: {resultado_MA:.2f}"
        if resultado_MA >= 7:
            label_status_MA["text"] = "Status Media Semestral: O aluno está aprovado!"
        else:
            label_status_MA["text"] = "Status Media Semestral: O aluno está de exame!"
    except ValueError:
        messagebox.showerror("Erro", "Por favor, insira valores válidos.")


def calcular_media_final():
    """Calcula a media final (MF) com base na media semestral (MS) e no exame."""
    global resultado_MF
    try:
        exame = float(entry_exame.get())
        resultado_MF = (exame + resultado_MA) / 2
        label_resultado_MF["text"] = f"Resultado Media Final: {resultado_MF:.2f}"
        if resultado_MF >= 5:
            label_status_MF["text"] = "Status Media Final: O aluno está aprovado!"
        else:
            label_status_MF["text"] = "Status Media Final: O aluno está reprovado!"
    except ValueError:
        messagebox.showerror("Erro", "Por favor, insira valores válidos.")


def novo():
    """Reseta os campos de entrada e os labels de resultados."""
    global resultado_MA, resultado_MF
    entry_np1.delete(0, tk.END)
    entry_np1.insert(0, "Nota do NP1")
    entry_np1.config(fg="gray")

    entry_np2.delete(0, tk.END)
    entry_np2.insert(0, "Nota do NP2")
    entry_np2.config(fg="gray")

    entry_exame.delete(0, tk.END)
    entry_exame.insert(0, "Nota do Exame")
    entry_exame.config(fg="gray")

    label_resultado_MA["text"] = "Resultado Media Semestral: "
    label_resultado_MF["text"] = "Resultado Media Final: "
    label_status_MA["text"] = "Status Media Semestral: "
    label_status_MF["text"] = "Status Media Final: "
    resultado_MA = 0
    resultado_MF = 0


def placeholder(event, entry, text):
    """Adiciona ou remove o placeholder nos campos de entrada."""
    if event.type == tk.EventType.FocusIn and entry.get() == text:
        entry.delete(0, tk.END)
        entry.config(fg="black")
    elif event.type == tk.EventType.FocusOut and entry.get() == "":
        entry.insert(0, text)
        entry.config(fg="gray")


# Janela principal
root = tk.Tk()
root.title("Calculadora de Notas")
root.geometry("450x450")
root.resizable(False, False)

# Painel principal
frame = tk.Frame(root, padx=20, pady=20)
frame.pack(fill="both", expand=True)

# Campos de entrada
entry_np1 = tk.Entry(frame, fg="gray")
entry_np1.insert(0, "Nota do NP1")
entry_np1.bind("<FocusIn>", lambda e: placeholder(e, entry_np1, "Nota do NP1"))
entry_np1.bind("<FocusOut>", lambda e: placeholder(e, entry_np1, "Nota do NP1"))
entry_np1.pack(pady=5)

entry_np2 = tk.Entry(frame, fg="gray")
entry_np2.insert(0, "Nota do NP2")
entry_np2.bind("<FocusIn>", lambda e: placeholder(e, entry_np2, "Nota do NP2"))
entry_np2.bind("<FocusOut>", lambda e: placeholder(e, entry_np2, "Nota do NP2"))
entry_np2.pack(pady=5)

entry_exame = tk.Entry(frame, fg="gray")
entry_exame.insert(0, "Nota do Exame")
entry_exame.bind("<FocusIn>", lambda e: placeholder(e, entry_exame, "Nota do Exame"))
entry_exame.bind("<FocusOut>", lambda e: placeholder(e, entry_exame, "Nota do Exame"))
entry_exame.pack(pady=5)

# Botões
btn_calcular_MA = tk.Button(frame, text="Calcular Media Semestral", command=calcular_media_semestral)
btn_calcular_MA.pack(pady=5)

btn_calcular_MF = tk.Button(frame, text="Calcular Media Final", command=calcular_media_final)
btn_calcular_MF.pack(pady=5)

btn_novo = tk.Button(frame, text="Novo", command=novo)
btn_novo.pack(pady=5)

# Labels para exibição dos resultados
label_resultado_MA = tk.Label(frame, text="Resultado Media Semestral: ")
label_resultado_MA.pack(pady=5)

label_resultado_MF = tk.Label(frame, text="Resultado Media Final: ")
label_resultado_MF.pack(pady=5)

label_status_MA = tk.Label(frame, text="Status Media Semestral: ")
label_status_MA.pack(pady=5)

label_status_MF = tk.Label(frame, text="Status Media Final: ")
label_status_MF.pack(pady=5)

# Inicia a interface
root.mainloop()
