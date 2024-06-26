package PokemonGame.PokemonGame;

import javax.swing.*;
import javax.swing.plaf.basic.BasicProgressBarUI;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.*;
import java.util.List;


//포켓몬 gui 클래스 전체적인 배틀 시스템 gui를 나타냄
public class PokemonGUI extends JPanel {
    private Battle battle;//전투 관리를 위한 battle 클래스 인스턴스
    private JLabel playerPokemonLabel; //플레이어 포켓몬 이름
    private JLabel opponentPokemonLabel;//상대 포켓몬 이름
    private JProgressBar playerHpBar; //플레이어 포켓몬 hp 바
    private JProgressBar opponentHpBar; // 상대 포켓몬 hp 바
    private JButton skill1; //1번 스킬 버튼
    private JButton skill2; //2번 스킬 버튼
    private JButton change; // 교체 버튼
    private JTextArea battleLog; //배틀 로그
    private JLabel playerLevel; // 플레이어 포켓몬 레벨
    private JLabel opponentLevel; //상대 포켓몬 레벨
    private JLabel pokeImg; //플레이어 포켓몬 이미지
    private JLabel oppoPokeImg; // 상대 포켓몬 이미지
    private PokemonAnimator playerAnimator; // 플레이어 포켓몬 애니메이션
    private PokemonAnimator opponentAnimator; // 상대 포켓몬 애니메이션
    private SoundEffect soundEffect; // 음향효과


    //포켓몬gui클래스 생성자
    public PokemonGUI(PokemonBattleBackground parentFrame) { //포켓몬 배틀 백그라운드 클래스를 부모프레임으로 설정
        setLayout(null);
        setSize(615, 533);
        resetBattle();
        soundEffect = new SoundEffect();
        resetGUI();
        updateGUI();
    }

    private void resetBattle() { //배틀 시스템 초기화 메서드
        Trainer player = Trainer.getTrainerByName("Player");
        Trainer gymLeader = Trainer.getTrainerByName("Gym Leader");
        battle = new Battle(player, gymLeader);
    }

    private void resetGUI() { // GUI 초기화 메서드, 구성요소 생성 및 배치
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 600, 500);
        add(layeredPane);


        JPanel logPanel = new JPanel(new BorderLayout());
        battleLog = new JTextArea(15, 30);
        battleLog.setFont(new Font("", Font.TYPE1_FONT, 12));

        JScrollPane scrollPane = new JScrollPane(battleLog);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);
        DefaultCaret caret = (DefaultCaret) battleLog.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        logPanel.add(scrollPane, BorderLayout.CENTER);
        logPanel.setBackground(new Color(0, 0, 0, 0));
        logPanel.setBounds(18, 360, 230, 90);
        layeredPane.add(logPanel, JLayeredPane.PALETTE_LAYER);

        playerPokemonLabel = new JLabel();
        playerHpBar = HealthBar();
        opponentPokemonLabel = new JLabel();
        opponentHpBar = HealthBar();
        playerLevel = new JLabel();
        opponentLevel = new JLabel();
        pokeImg = new JLabel();
        oppoPokeImg = new JLabel();

        playerPokemonLabel.setBounds(320, 270, 100, 20);
        playerHpBar.setBounds(320, 290, 200, 20);
        playerLevel.setBounds(490, 270, 100, 20);
        opponentPokemonLabel.setBounds(70, 40, 100, 20);
        opponentHpBar.setBounds(70, 60, 200, 20);
        opponentLevel.setBounds(240, 40, 100, 20);
        pokeImg.setBounds(60, 140, 200, 200);
        oppoPokeImg.setBounds(340, 0, 200, 200);

        layeredPane.add(playerPokemonLabel, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(playerHpBar, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(playerLevel, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(opponentPokemonLabel, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(opponentHpBar, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(opponentLevel, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(pokeImg, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(oppoPokeImg, JLayeredPane.PALETTE_LAYER);

        skill1 = SB("move1");
        skill1.setBounds(290, 375, 120, 30);
        layeredPane.add(skill1, JLayeredPane.PALETTE_LAYER);

        skill2 = SB("move2");
        skill2.setBounds(430, 375, 120, 30);
        layeredPane.add(skill2, JLayeredPane.PALETTE_LAYER);

        change = SB("Switch Poke");
        change.setBounds(360, 420, 120, 50);
        layeredPane.add(change, JLayeredPane.PALETTE_LAYER);

        BackGround backGround = new BackGround("PokemonGame/src/realui.png");
        backGround.setBounds(0, 0, 600, 500);
        layeredPane.add(backGround, JLayeredPane.DEFAULT_LAYER);

        playerAnimator = new PokemonAnimator(pokeImg, pokeImg.getX(), pokeImg.getY());
        opponentAnimator = new PokemonAnimator(oppoPokeImg, oppoPokeImg.getX(), oppoPokeImg.getY());


        //스킬 버튼에 대한 액션리스너 추가 메서드
        skill1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String moveName = battle.getTrainer1().getAvailablePokemon().getMoves().get(0).getName();
                Player(0);
                playMoveSound(moveName);
                playerAnimator.animateAttack();
            }
        });

        skill2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String moveName = battle.getTrainer1().getAvailablePokemon().getMoves().get(1).getName();
                Player(1);
                playMoveSound(moveName);
                playerAnimator.animateAttack();
            }
        });

        change.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changepoke();
            }
        });
    }

    private JButton SB(String text) { //스킬 버튼 디자인 설정
        JButton button = new JButton(text);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBackground(Color.WHITE);
        button.setForeground(Color.BLACK);
        button.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        return button;
    }

    private JProgressBar HealthBar() { // 헬스바 디자인 설정
        JProgressBar healthBar = new JProgressBar();
        healthBar.setStringPainted(true);
        healthBar.setPreferredSize(new Dimension(200, 20));
        healthBar.setUI(new BasicProgressBarUI() {
            @Override
            protected Color getSelectionForeground() {
                return Color.red;
            }

            @Override
            protected Color getSelectionBackground() {
                return Color.orange;
            }
        });
        return healthBar;
    }

    private void updateHealth(JProgressBar healthBar, int currentHp, int maxHp) { //헬스바 업데이트
        int healthPercentage = (int) (((double) currentHp / maxHp) * 100);//
        healthBar.setValue(healthPercentage);

        if (healthPercentage <= 30) {// 체력이 30보다 낮으면 빨간색
            healthBar.setForeground(Color.red);
        } else if (healthPercentage <= 50) {//체력이 50보다 낮으면 주황색
            healthBar.setForeground(Color.orange);
        } else {
            healthBar.setForeground(Color.green);
        }
    }

    private boolean playerCanAttack = true;

    //배틀 클래스를 상속받아 포켓몬 배틀 진행
    private void Player(int moveIndex) { // 플레이어 공격 실행 메서드
        if (!playerCanAttack) {
            return;
        }

        Pokemon playerPokemon = battle.getTrainer1().getAvailablePokemon(); //배틀 클래스에서 트레이너 객체를 사용하여 메서드 호출
        Pokemon opponentPokemon = battle.getTrainer2().getAvailablePokemon();
        Move playerMove = playerPokemon.getMoves().get(moveIndex);
        playerAnimator.animateAttack();
        battle.performMove(playerPokemon, opponentPokemon, playerMove);
        battleLog.append(playerPokemon.getName() + " 은(는) " + playerMove.getName() + " 을(를) 사용했다!\n");
        playerCanAttack = false;
        //만약 적 포켓몬이 쓰러졌다면 포켓몬 교체
        if (opponentPokemon.isFainted()) {
            chagneoppo();
        } else {//쓰레드를 줘서 애니메이션 효과와 소리 효과 타이밍 결정
            new Thread(() -> {
                try {
                    Thread.sleep(2000);
                    opponentAnimator.animateAttack();
                    soundEffect.Damage();
                    updateGUI();
                    new Thread(() -> {
                        try {
                            Thread.sleep(2000);
                            opponentAnimator.animateHit();
                            performOpponentMove();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }).start();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

        }
    }

    //위와 동일하나 상대 포켓몬
    private void performOpponentMove() {
        if (playerCanAttack) {
            return;
        }

        Pokemon opponentPokemon = battle.getTrainer2().getAvailablePokemon();
        Pokemon playerPokemon = battle.getTrainer1().getAvailablePokemon();

        Move opponentMove = ((GymLeader) battle.getTrainer2()).chooseMove(opponentPokemon, playerPokemon);
        battle.performMove(opponentPokemon, playerPokemon, opponentMove);
        {

            soundEffect.enemyhit();
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                        playerAnimator.animateHit();
                        soundEffect.Damage();
                        updateGUI();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            thread.start();
        }



        battleLog.append(opponentPokemon.getName() + " 은 " + opponentMove.getName() + " 을(를) 사용했다!!\n");

        playerCanAttack = true;

        new Thread(() -> {
            try {

                Thread.sleep(1000);

            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }).start();
    }


    //상대포켓몬 교체 메서드
    private void chagneoppo() {
        Pokemon opponentPokemon = battle.getTrainer2().getAvailablePokemon();
        if (opponentPokemon == null) {
            battleLog.append("상대의 포켓몬이 모두 쓰러졌습니다.\n");
            return;
        }

        battleLog.append(opponentPokemon.getName() + " 은(는) 쓰러졌다!\n");
        opponentAnimator.animateSummon();
        battleLog.append("체육관 관장이 포켓몬을 교체했다.\n");

        performOpponentMove();
    }

    private void updateGUI() { //GUI업데이트 메서드
        Pokemon playerPokemon = battle.getTrainer1().getAvailablePokemon();
        Pokemon opponentPokemon = battle.getTrainer2().getAvailablePokemon();

        if (playerPokemon == null || opponentPokemon == null) {
            String winner = battle.getWinner().getName();
            battleLog.append("배틀 종료 승자는: " + winner + "\n");
            skill1.setEnabled(false);
            skill2.setEnabled(false);
            change.setEnabled(false);

            return;
        }
        //플레이어 포켓몬 이름과 체력바
        playerPokemonLabel.setText(playerPokemon.getName());
        updateHealth(playerHpBar, playerPokemon.getCurrentHp(), playerPokemon.getHp());
        //상대 포켓몬 이름과 체력바

        opponentPokemonLabel.setText(opponentPokemon.getName());
        updateHealth(opponentHpBar, opponentPokemon.getCurrentHp(), opponentPokemon.getHp());

        //플레이어 포켓몬의 첫번째와 두번째 기술을 가져옴
        Move move1 = playerPokemon.getMoves().get(0);
        Move move2 = playerPokemon.getMoves().get(1);

        //포켓몬에 따른 스킬 텍스트 결정
        skill1.setText(move1.getName());
        skill2.setText(move2.getName());

        playerLevel.setText("LV: " + playerPokemon.getLevel());
        opponentLevel.setText("LV: " + opponentPokemon.getLevel());

        //포켓몬에 따른 이미지 결정
        pokeImg.setIcon(new ImageIcon("PokemonGame/src/" + playerPokemon.getName() + ".png"));
        oppoPokeImg.setIcon(new ImageIcon("PokemonGame/src/" + opponentPokemon.getName() + ".png"));
    }
    //포켓몬 교체 메서드
    private void changepoke() {
        Trainer player = battle.getTrainer1();
        List<Pokemon> pokemons = player.getPokemons();
        String[] options = pokemons.stream()
                .filter(pokemon -> !pokemon.isFainted() && pokemon != player.getAvailablePokemon())
                .map(Pokemon::getName)
                .toArray(String[]::new);

        if (options.length == 0) {
            battleLog.append("더 이상은 포켓몬이 남지 않았어!\n");
            return;
        }

        String selectedPokemonName = (String) JOptionPane.showInputDialog(
                null,
                "교체할 포켓몬을 고르시오:",
                "포켓몬 교체",
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]
        );

        if (selectedPokemonName != null) {
            for (Pokemon pokemon : pokemons) {
                if (pokemon.getName().equals(selectedPokemonName)) {
                    int currentIndex = pokemons.indexOf(player.getAvailablePokemon());

                    pokeImg.setIcon(new ImageIcon("PokemonGame/src/" + pokemon.getName() + ".png"));

                    playerAnimator = new PokemonAnimator(pokeImg, pokeImg.getX(), pokeImg.getY());
                    playerAnimator.animateSummon();

                    pokemons.set(currentIndex, pokemon);
                    break;
                }
            }
        }

        updateGUI();
        performOpponentMove();
    }

    //포켓몬 스킬 사운드
    private void playMoveSound(String moveName) {
        String soundFilePath = "PokemonGame/src/sfx/" + moveName + ".wav";
        SoundEffect.playSkillSound(soundFilePath);
    }



}
