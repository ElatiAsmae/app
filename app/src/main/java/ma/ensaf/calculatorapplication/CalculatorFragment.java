package ma.ensaf.calculatorapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorFragment extends Fragment implements View.OnClickListener {
    private TextView inputText, outputText;
    private String input, output, newOutput;

    private Button button0, button1, button2, button3, button4, button5, button6, button7,
            button8, button9, buttonAdd, buttonMultiply, buttonSubs, buttonDivision, buttonPoint, buttonPercent,
            buttonPower, buttonEqual, buttonClear;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculator, container, false);

        inputText = view.findViewById(R.id.input_text);
        outputText = view.findViewById(R.id.output_text);

        button0 = view.findViewById(R.id.btn0);
        button1 = view.findViewById(R.id.btn1);
        button2 = view.findViewById(R.id.btn2);
        button3 = view.findViewById(R.id.btn3);
        button4 = view.findViewById(R.id.btn4);
        button5 = view.findViewById(R.id.btn5);
        button6 = view.findViewById(R.id.btn6);
        button7 = view.findViewById(R.id.btn7);
        button8 = view.findViewById(R.id.btn8);
        button9 = view.findViewById(R.id.btn9);
        buttonAdd = view.findViewById(R.id.addition);
        buttonMultiply = view.findViewById(R.id.multiplication);
        buttonDivision = view.findViewById(R.id.division);
        buttonSubs = view.findViewById(R.id.substract);
        buttonPoint = view.findViewById(R.id.point);
        buttonPower = view.findViewById(R.id.power);
        buttonEqual = view.findViewById(R.id.equals);
        buttonPercent = view.findViewById(R.id.pourcentage);
        buttonClear = view.findViewById(R.id.clear);

        setButtonClickListeners();

        return view;
    }

    private void setButtonClickListeners() {
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonAdd.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonDivision.setOnClickListener(this);
        buttonSubs.setOnClickListener(this);
        buttonPoint.setOnClickListener(this);
        buttonPower.setOnClickListener(this);
        buttonEqual.setOnClickListener(this);
        buttonPercent.setOnClickListener(this);
        buttonClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String data = button.getText().toString();

        switch (data) {
            case "C":
                input = null;
                output = null;
                newOutput = null;
                outputText.setText("");
                break;

            case "^":
                solve();
                input += "^";
                break;
            case "*":
                solve();
                input += "*";
                break;
            case "+":
                solve();
                input += "+";
                break;
            case "-":
                solve();
                input += "-";
                break;
            case "/":
                solve();
                input += "/";
                break;

            case "=":
                solve();
                break;

            case "%":
                input += "%";
                double d = Double.parseDouble(inputText.getText().toString()) / 100;
                outputText.setText(String.valueOf(d));
                break;

            default:
                if (input == null) {
                    input = "";
                }
                input += data;
        }
        inputText.setText(input);
    }

    private void solve() {
        if (input.split("\\+").length == 2) {
            String numbers[] = input.split("\\+");
            try {
                double d = Double.parseDouble(numbers[0]) + Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                outputText.setText(newOutput);
                input = d +"";
            }catch (Exception e) {
                outputText.setText(e.getMessage().toString());
            }
        }
        if (input.split("\\*").length == 2) {
            String numbers[] = input.split("\\*");
            try {
                double d = Double.parseDouble(numbers[0]) * Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                outputText.setText(newOutput);
                input = d +"";
            }catch (Exception e){
                outputText.setText(e.getMessage().toString());
            }
        }
        if (input.split("\\/").length == 2) {
            String numbers[] = input.split("\\/");
            try {
                double d = Double.parseDouble(numbers[0]) / Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                outputText.setText(newOutput);
                input = d +"";
            }catch (Exception e){
                outputText.setText(e.getMessage().toString());
            }
        }
        if (input.split("\\^").length == 2) {
            String numbers[] = input.split("\\^");
            try {
                double d = Math.pow(Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1]));
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                outputText.setText(newOutput);
                input = d +"";
            }catch (Exception e){
                outputText.setText(e.getMessage().toString());
            }
        }
        if (input.split("\\-").length == 2) {
            String numbers[] = input.split("\\-");
            try {
                double d = Double.parseDouble(numbers[0]) - Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                outputText.setText(newOutput);
                input = d + "";
            }catch (Exception e){
                outputText.setText(e.getMessage().toString());
            }
        }
    }
    private String cutDecimal(String number){
        String n [] = number.split("\\.");
        if (n.length >1){
            if (n[1].equals("0")){
                number = n[0];
            }
        }
        return number;
    }

}
