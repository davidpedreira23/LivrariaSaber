#Livraria Saber




Estou indo na direção correta ? //TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
void main() {
    Scanner scanner = new Scanner(System.in);

   System.out.println("Quantos degraus tem a escada");
   int Quantidade = scanner.nextInt();

   int[] array = new int[Quantidade];
// ATRIBUI OS CUSTOS DE CADA DEGRAU
   for(int i =0; i<Quantidade; i++){
      if(array[i] % 2 ==0) {
          array[i] =2;
      }else {array[i] =1;
      }
      // VERIFICA SE É MELHOR DA 1 OU 2 PASSOS
      int n = 0;
      if (array [i-1] < array [i]) {
          n = n+1;

      }else {
          n = n+2;

      }

   }

}
------------------------


Você está com a ideia de que precisa comparar "1 passo" com "2 passos", e isso é bom. Mas o código ainda mistura conceitos, então vou ser direto: não, ainda não está na direção certa, mas dá para consertar.
O que está confuso no código

1. O array array deveria guardar os custos que você recebe, mas você está inventando valores.
java

if(array[i] % 2 == 0) { array[i] = 2; } else { array[i] = 1; }

Como o array acaba de ser criado, todo array[i] vale 0, então tudo vira 2. Os custos são dados do problema (ex: {10, 15, 20}), não algo que o programa calcula. Você pode fixar direto no código.

2. array[i-1] quebra quando i = 0, porque não existe posição -1. É por isso que os casos base ficam separados, como no Fibonacci.

3. A variável n guarda "quantos passos dar", mas a DP não guarda passos. Ela guarda o custo mínimo acumulado para chegar em cada degrau. Essa é a mudança de cabeça mais importante: o segundo array (dp) responde "quanto gastei até aqui no melhor caso?".
O molde (igual ao Fibonacci que você fez)
java

void main() {
    int[] custo = {10, 15, 20};
    int n = custo.length;

    int[] dp = new int[n];

    for (int i = 0; i < n; i++) {
        if (i == 0) {
            dp[i] = ___;
        } else if (i == 1) {
            dp[i] = ___;
        } else {
            dp[i] = ___;
        }
    }

    // resposta: o menor entre dp[n-1] e dp[n-2]
    System.out.println(___);
}

Compare com o seu Fibonacci: a estrutura if / else if / else é idêntica.
Preencher os espaços

    dp[0]: chegar no degrau 0 custa o próprio custo dele.
    dp[1]: idem para o degrau 1.
    dp[i] (i ≥ 2): você veio de i-1 ou de i-2. Pegue o menor dos dois dp e some custo[i].
    Resposta: você chega ao topo vindo do último ou do penúltimo degrau. Pegue o menor dos dois dp.

Tente preencher e me mande. Com {10, 15, 20} deve imprimir 15.
